/*
 * Copyright 2021 wkk-knight
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.wkk.compose.catalog.ui.demopages.layout.demos

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.MeasurePolicy
import androidx.compose.ui.layout.ParentDataModifier
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEachIndexed
import com.wkk.compose.catalog.ui.theme.Blue
import com.wkk.compose.catalog.ui.theme.Red
import com.wkk.compose.catalog.ui.widget.SubTitle
import com.wkk.compose.catalog.ui.widget.VerticalDivider
import kotlin.math.roundToInt

@Composable
fun CustomLayoutDemo() {
    Box {
        val rowWidth = 160.dp
        VerticalDivider(Modifier.padding(start = rowWidth))
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            SubTitle("原版Row")
            Row(Modifier.size(rowWidth, 100.dp)) { RowChildren() }
            SubTitle("自定义Layout——Row v1.0")
            MyRowV1(Modifier.size(rowWidth, 100.dp)) { RowChildren() }
            SubTitle("自定义Layout——Row v2.0")
            MyRowV2(Modifier.size(rowWidth, 100.dp)) { RowChildren() }
            SubTitle("自定义Layout——Row v3.0")
            MyRowV3(Modifier.size(rowWidth, 100.dp)) { RowChildren() }
            SubTitle("自定义Layout——Row v4.0")
        }
    }
}

@Composable
private fun RowChildren() {
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(Blue)
    )
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(Red)
    )
}

/**
 * 自定义Layout Row v1.0
 *  实现简单水平排列
 */
@Composable
private fun MyRowV1(modifier: Modifier = Modifier, content: @Composable () -> Unit) {

    /**
     * 布局的测量策略 MeasurePolicy 是一个[函数式接口](https://www.kotlincn.net/docs/reference/fun-interfaces.html)(kotlin 1.4特性)
     *  ```kotlin
     *  //如果是普通接口我们需要这样写
     *  val measurePolicy = object : MeasurePolicy {
     *      ////进行 children 的测量及在布局的位置
     *     override fun MeasureScope.measure(
     *         measurables: List<Measurable>,
     *         constraints: Constraints
     *      ): MeasureResult {
     *          TODO( children 测量&布局逻辑)
     *      }
     *    }
     *  //函数式接口 支持 SAM 转换，所有上面可以简写成下面形式
     *  val measurePolicy = MeasurePolicy {  measurables, constraints ->
     *          TODO( children 测量&布局逻辑)
     *  }
     *  ```
     *  下面的例子中我就是用简写的形式了，你要记住 lambda块 就是原始接口的 measure 方法。
     *
     */
    val measurePolicy = MeasurePolicy { measurables, constraints ->
        val placeables = measurables.map { child ->
            // 测量每一个 child
            Log.i(CustomLayout.TAG, "measurable-Class:${child.javaClass.name}")
            Log.i(CustomLayout.TAG, "constraints:$constraints")
            // 进行测量 控制 child 宽高在约束constraints范围内
            child.measure(constraints)
        }
        var xPosition = 0
        layout(constraints.minWidth, constraints.minHeight) {
            placeables.forEach { placeable ->
                // 放置每一个 child
                Log.i(
                    CustomLayout.TAG,
                    " placeable:width=${placeable.width},height=${placeable.height}"
                )
                // 此方法必须在Placeable.PlacementScope 作用域下调用
                placeable.placeRelative(xPosition, 0)
                xPosition += placeable.width
            }
        }
    }
    Layout(content = content, modifier = modifier, measurePolicy = measurePolicy)
}

/**
 * 自定义Layout Row v2.0
 * 扩大测量约束范围，让children测量后的宽高尽可能和自己设置的大小一致
 */
@Composable
private fun MyRowV2(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    // 布局的测量策略 和V1一样，只是这里用了 lambda 简写
    val measurePolicy = MeasurePolicy { measurables, constraints ->
        // 用于写测量逻辑，返回测量结果
        val placeables = measurables.map { measurable ->
            // 测量每一个 child
            // 相对v1版本只有改这个测量的约束条件
            // 假设 child 自己设置的大小是[width=100,height=100]
            // 假设此时父容器测量策略MeasurePolicy的measure方法的constraints参数
            // 的值是Constraints(minWidth = 120, maxWidth = 120, minHeight = 160, maxHeight = 160)
            // 如果是v1版本测测量方案 measurable.measure(constraints)，由于child 的宽高要在约束条件范围内
            // 那么child 测量后的宽高是[width=120,height=160],child 就会变得比原来大。
            // child希望是自己设置的大小，所有我们可以修改child 在测量时的约束条件，minWidth,minHeight 都改成0 最大值不变
            // 按照上面假设值，100在[0,120]区间，100也在[0,160]区间，最终child 测量的大小就是[width=100,height=100]，和自己原来设置的一样大
            measurable.measure(Constraints(0, constraints.maxWidth, 0, constraints.maxHeight))
        }
        var xPosition = 0
        layout(constraints.minWidth, constraints.minHeight) {
            placeables.forEach { placeable ->
                // 放置每一个 child
                Log.i(
                    CustomLayout.TAG,
                    " placeable:width=${placeable.width},height=${placeable.height}"
                )
                placeable.placeRelative(xPosition, 0)
                xPosition += placeable.width
            }
        }
    }
    Layout(content = content, modifier = modifier, measurePolicy = measurePolicy)
}

/**
 * 自定义Layout Row v3.0
 * 解决 child 大小超过父容器大小的问题
 */
@Composable
private fun MyRowV3(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    val measurePolicy = MeasurePolicy { measurables, constraints ->
        // 记录children 已经占据的空间
        var childrenSpace = 0
        val placeables = measurables.map { child ->
            val placeable = child.measure(
                Constraints(
                    0,
                    constraints.maxWidth - childrenSpace, // 限制child在剩余空间范围内
                    0,
                    constraints.maxHeight
                )
            )
            // 每次测量后更新 children 占据的空间
            childrenSpace += placeable.width
            placeable
        }
        var xPosition = 0
        layout(constraints.minWidth, constraints.minHeight) {
            placeables.forEach { placeable ->
                // 放置每一个 child
                placeable.placeRelative(xPosition, 0)
                xPosition += placeable.width
            }
        }
    }
    Layout(content = content, modifier = modifier, measurePolicy = measurePolicy)
}

/**
 * 自定义Layout Row v4.0
 *
 * 带 weight 功能的 Row
 */
@Composable
private fun MyRowV4(modifier: Modifier = Modifier, content: @Composable MyRowScope.() -> Unit) {
    val measurePolicy = MeasurePolicy { measurables, constraints ->
        // 存放测量后的 child 信息
        val placeables = arrayOfNulls<Placeable>(measurables.size)
        // 通过该parentData 就可以获取到我们设置的MyRowParentData数据了
        val parentDatas =
            Array(measurables.size) { measurables[it].parentData as? MyRowParentData }
        // 记录children 已经占据的空间
        var childrenSpace = 0
        // 所有权重之和
        var totalWeight = 0f
        // 设置了weight的child个数
        var weightChildrenCount = 0
        measurables.fastForEachIndexed { index, child ->
            val weight = parentDatas[index]?.weight
            if (weight != null) { // 有weight的child 记录一下
                totalWeight += weight
                weightChildrenCount++
            } else { // 没有weight的child直接测量
                val placeable = child.measure(
                    Constraints(
                        0,
                        constraints.maxWidth - childrenSpace, // 限制child在剩余空间范围内
                        0,
                        constraints.maxHeight
                    )
                )
                // 每次测量后更新 children 占据的空间
                childrenSpace += placeable.width
                placeables[index] = placeable
            }
        }
        // 把剩下的空间平均分布
        val weightUnitSpace =
            if (totalWeight > 0) (constraints.maxWidth - childrenSpace) / totalWeight else 0f
        measurables.fastForEachIndexed { index, child ->
            val weight = parentDatas[index]?.weight
            if (weight != null) {
                // 根据 child 的 weight 分配空间
                val distributionSpace = (weightUnitSpace * weight).roundToInt()
                val placeable = child.measure(
                    Constraints(
                        distributionSpace,
                        distributionSpace,
                        0,
                        constraints.maxHeight
                    )
                )
                placeables[index] = placeable
            }
        }

        var xPosition = 0
        layout(constraints.minWidth, constraints.minHeight) {
            placeables.forEach { placeable ->
                if (placeable == null) {
                    return@layout
                }
                // 放置每一个 child
                placeable.placeRelative(xPosition, 0)
                xPosition += placeable.width
            }
        }
    }

    Layout(content = { MyRowScope.content() }, modifier = modifier, measurePolicy = measurePolicy)
}

// 用于保存ParentData数据模型
data class MyRowParentData(var weight: Float = 0f)

interface MyRowScope {
    fun Modifier.weight(weight: Float) = this.then(MyRowWeightModifier(weight))

    // 创建一个单例
    companion object : MyRowScope
}

data class MyRowWeightModifier(val weight: Float) : ParentDataModifier {
    // 修改ParentData
    override fun Density.modifyParentData(parentData: Any?): Any {
        // 如果参数类型正确且不为空，就修改一下直接返回，否则创建一个新的对象，修改后再返回
        var data = parentData as? MyRowParentData?
        if (data == null) {
            data = MyRowParentData()
        }
        data.weight = weight
        return data
    }
}

object CustomLayout {
    const val TAG = "CustomLayout"
}

@Composable
fun MyOwnColumn(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = content
    ) { measurables, constraints ->
        // Don't constrain child views further, measure them with given constraints
        // List of measured children
        val placeables = measurables.map { measurable ->
            // Measure each child
            measurable.measure(constraints)
        }

        // Track the y co-ord we have placed children up to
        var yPosition = 0

        // Set the size of the layout as big as it can
        layout(constraints.maxWidth, constraints.maxHeight) {
            // Place children in the parent layout
            placeables.forEach { placeable ->
                // Position item on the screen
                placeable.placeRelative(x = 0, y = yPosition)

                // Record the y co-ord placed up to
                yPosition += placeable.height
            }
        }
    }
}

@Preview
@Composable
fun CustomLayoutPreview() {
    CustomLayoutDemo()
}
