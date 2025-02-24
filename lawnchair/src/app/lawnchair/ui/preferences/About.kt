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

import android.content.Intent
import androidx.annotation.StringRes
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import app.lawnchair.util.preferences.getFormattedVersionName
import com.android.launcher3.R
import com.google.android.gms.oss.licenses.OssLicensesMenuActivity

class TeamMember(val name: String, @StringRes val descriptionRes: Int, val photoUrl: String, val socialUrl: String)

val teamMembers = listOf(
    TeamMember(
        name = "Amogh Lele",
        descriptionRes = R.string.development,
        photoUrl = "https://avatars.githubusercontent.com/u/31761843",
        socialUrl = "https://www.linkedin.com/in/amogh-lele/"
    ),
    TeamMember(
        name = "Antonio J. Roa Valverde",
        descriptionRes = R.string.development,
        photoUrl = "https://avatars.githubusercontent.com/u/914983",
        socialUrl = "https://twitter.com/6020peaks"
    ),
    TeamMember(
        name = "Daniel Souza",
        descriptionRes = R.string.support,
        photoUrl = "https://avatars.githubusercontent.com/u/32078304",
        socialUrl = "https://github.com/DanGLES3"
    ),
    TeamMember(
        name = "David Sn",
        descriptionRes = R.string.devops,
        photoUrl = "https://i.imgur.com/b65akTl.png",
        socialUrl = "https://codebucket.de"
    ),
    TeamMember(
        name = "Giuseppe Longobardo",
        descriptionRes = R.string.support,
        photoUrl = "https://avatars.githubusercontent.com/u/49398464",
        socialUrl = "https://github.com/joseph-20"
    ),
    TeamMember(
        name = "Harsh Shandilya",
        descriptionRes = R.string.development,
        photoUrl = "https://avatars.githubusercontent.com/u/13348378",
        socialUrl = "https://github.com/msfjarvis"
    ),
    TeamMember(
        name = "Manuel Lorenzo",
        descriptionRes = R.string.development,
        photoUrl = "https://avatars.githubusercontent.com/u/183264",
        socialUrl = "https://twitter.com/noloman"
    ),
    TeamMember(
        name = "paphonb",
        descriptionRes = R.string.development,
        photoUrl = "https://avatars.githubusercontent.com/u/8080853",
        socialUrl = "https://twitter.com/paphonb"
    ),
    TeamMember(
        name = "raphtlw",
        descriptionRes = R.string.development,
        photoUrl = "https://avatars.githubusercontent.com/u/47694127",
        socialUrl = "https://twitter.com/raphtlw"
    ),
    TeamMember(
        name = "Rhyse Simpson",
        descriptionRes = R.string.quickswitch_maintenance,
        photoUrl = "https://avatars.githubusercontent.com/u/7065700",
        socialUrl = "https://twitter.com/skittles9823"
    ),
    TeamMember(
        name = "Rik Koedoot",
        descriptionRes = R.string.support_and_pr,
        photoUrl = "https://avatars.githubusercontent.com/u/29402532",
        socialUrl = "https://twitter.com/rikkoedoot"
    ),
)

@ExperimentalAnimationApi
@Composable
fun About() {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .verticalScroll(rememberScrollState()), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.requiredHeight(24.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_home_comp),
            contentDescription = null,
            modifier = Modifier
                .width(96.dp)
                .height(96.dp)
                .clip(
                    CircleShape
                )
        )
        Spacer(modifier = Modifier.requiredHeight(16.dp))
        Text(
            text = stringResource(id = R.string.derived_app_name),
            style = MaterialTheme.typography.h6,
            color = MaterialTheme.colors.onBackground
        )
        CompositionLocalProvider(
            LocalContentAlpha provides ContentAlpha.medium,
            LocalContentColor provides MaterialTheme.colors.onBackground
        ) {
            Text(text = getFormattedVersionName(LocalContext.current), style = MaterialTheme.typography.body1)
        }
        Spacer(modifier = Modifier.requiredHeight(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        ) {
            LawnchairLink(
                iconResId = R.drawable.ic_new_releases,
                label = stringResource(id = R.string.news),
                modifier = Modifier.weight(1f),
                url = "https://t.me/lawnchairci"
            )
            LawnchairLink(
                iconResId = R.drawable.ic_help,
                label = stringResource(id = R.string.support),
                modifier = Modifier.weight(1f),
                url = "https://t.me/lccommunity"
            )
            LawnchairLink(
                iconResId = R.drawable.ic_twitter,
                label = stringResource(id = R.string.twitter),
                modifier = Modifier.weight(1f),
                url = "https://twitter.com/lawnchairapp"
            )
            LawnchairLink(
                iconResId = R.drawable.ic_github,
                label = stringResource(id = R.string.github),
                modifier = Modifier.weight(1f),
                url = "https://github.com/LawnchairLauncher/Lawnchair"
            )
        }
        Spacer(modifier = Modifier.requiredHeight(16.dp))
        ContributorCard(
            name = "Patryk Michalik",
            description = stringResource(id = R.string.patryk_description),
            photoUrl = "https://raw.githubusercontent.com/patrykmichalik/brand/master/logo-on-indigo.png",
            links = {
                ContributorLink(iconResId = R.drawable.ic_website, url = "https://patrykmichalik.com")
                ContributorLink(iconResId = R.drawable.ic_twitter, url = "https://twitter.com/patrykmichalik_")
                ContributorLink(iconResId = R.drawable.ic_github, url = "https://github.com/patrykmichalik")
            }
        )
        ContributorCard(
            name = "Kshitij Gupta",
            includeTopPadding = true,
            description = stringResource(id = R.string.kshitij_description),
            photoUrl = "https://avatars.githubusercontent.com/u/18647641",
            links = {
                ContributorLink(iconResId = R.drawable.ic_twitter, url = "https://twitter.com/Agent_Fabulous")
                ContributorLink(iconResId = R.drawable.ic_github, url = "https://github.com/AgentFabulous")
            }
        )
        PreferenceGroup(heading = stringResource(id = R.string.team_members)) {
            teamMembers.forEachIndexed { index, it ->
                ContributorRow(
                    name = it.name,
                    description = stringResource(it.descriptionRes),
                    url = it.socialUrl,
                    photoUrl = it.photoUrl,
                    showDivider = index != teamMembers.size - 1
                )
            }
        }
        PreferenceGroup {
            ClickListenerPreference(label = stringResource(id = R.string.acknowledgements), showDivider = false, onClick = {
                val intent = Intent(context, OssLicensesMenuActivity::class.java)
                OssLicensesMenuActivity.setActivityTitle(context.getString(R.string.acknowledgements))
                context.startActivity(intent)
            })
        }
        Spacer(modifier = Modifier.requiredHeight(16.dp))
    }
}
