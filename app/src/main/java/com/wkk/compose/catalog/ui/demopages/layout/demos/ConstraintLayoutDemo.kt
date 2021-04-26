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

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

/**
 * 约束布局
 */
@Composable
fun ConstraintLayoutDemo() {

    ConstraintLayout(Modifier.fillMaxWidth()) {
        // 创建参考，Compose 没有id 就用这个代替
        val button = createRef()

        Button(
            onClick = { },
            modifier = Modifier.constrainAs(button/*关联参考*/) {
                // this:ConstrainScope
                // 相当于 app:layout_constraintTop_toTopOf="parent" 还设置了距离顶部10.dp
                top.linkTo(parent.top, 10.dp)
                // <=> app:layout_constraintTop_toTopOf="parent"
                start.linkTo(parent.start)
                // <=> app:layout_constraintEnd_toEndOf="parent"
                end.linkTo(parent.end)
            }
        ) {
            Text(text = "Button")
        }

        val text = createRef()
        Text(
            text = "Android",
            Modifier.constrainAs(text) {
                // app:layout_constraintTop_toBottomOf="@id/button" 还设置了距离button 底部30.dp
                top.linkTo(button.bottom, 30.dp)
                start.linkTo(button.start)
                end.linkTo(button.end)
            }
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ColumnDemoPreview() {
    ConstraintLayoutDemo()
}
