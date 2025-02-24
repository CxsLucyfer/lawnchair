/*
 * Copyright 2021, Lawnchair
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package app.lawnchair.ui.preferences

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ClickListenerPreference(
    label: String,
    subtitle: String? = null,
    onClick: () -> Unit,
    showDivider: Boolean = true
) =
    PreferenceTemplate(height = if (subtitle != null) 72.dp else 52.dp, showDivider = showDivider) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .clickable(onClick = onClick)
                .padding(start = 16.dp, end = 16.dp),
        ) {
            Text(text = label, style = MaterialTheme.typography.subtitle1, color = MaterialTheme.colors.onBackground)
            subtitle?.let {
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text(text = it, style = MaterialTheme.typography.body2, color = MaterialTheme.colors.onBackground)
                }
            }
        }
    }