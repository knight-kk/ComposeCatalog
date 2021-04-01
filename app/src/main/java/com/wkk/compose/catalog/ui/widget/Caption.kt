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
package com.wkk.compose.catalog.ui.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wkk.compose.catalog.R

@Composable
fun Caption(title: String, desc: String? = null) {

    Column(modifier = Modifier.padding(10.dp)) {
        // Modifier.width(IntrinsicSize.Max) = 指定宽度为内容中最大的宽度
        Column(modifier = Modifier.width(IntrinsicSize.Max)) {
            Row(modifier = Modifier.padding(4.dp), verticalAlignment = Alignment.CenterVertically) {
                Image(
                    modifier = Modifier.width(24.dp),
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_compose_logo),
                    contentDescription = "compose_logo"
                )
                Text(
                    modifier = Modifier.padding(4.dp, 0.dp),
                    text = title,
                    style = MaterialTheme.typography.h6,
                )
            }

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
                    .background(
                        Brush.horizontalGradient(
                            0.1f to Color(61, 220, 132),
                            1f to Color(7, 48, 66)
                        ),
                        RoundedCornerShape(1.dp)
                    )
            )
        }

        if (!desc.isNullOrEmpty()) {
            Text(
                modifier = Modifier.padding(top = 6.dp),
                text = desc,
                style = MaterialTheme.typography.body2
            )
        }
    }
}

@Preview
@Composable
fun PreviewCaption() {
    Caption(title = "标题", "这是长长的描述")
}
