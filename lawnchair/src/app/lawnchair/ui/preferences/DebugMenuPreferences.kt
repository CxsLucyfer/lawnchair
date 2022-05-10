package app.lawnchair.ui.preferences

import android.content.Intent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import app.lawnchair.preferences.PreferenceManager
import app.lawnchair.preferences.getAdapter
import app.lawnchair.preferences.preferenceManager
import app.lawnchair.preferences2.PreferenceManager2
import app.lawnchair.preferences2.preferenceManager2
import app.lawnchair.ui.preferences.components.*
import com.android.launcher3.settings.DeveloperOptionsFragment
import com.android.launcher3.settings.SettingsActivity
import com.patrykmichalik.preferencemanager.Preference

@ExperimentalMaterialApi
@ExperimentalAnimationApi
fun NavGraphBuilder.debugMenuGraph(route: String) {
    preferenceGraph(route, { DebugMenuPreferences() })
}

/**
 * A screen to house unfinished preferences and debug flags
 */
@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Composable
fun DebugMenuPreferences() {
    val prefs = preferenceManager()
    val prefs2 = preferenceManager2()
    val flags = remember { prefs.getDebugFlags() }
    val flags2 = remember { prefs2.debugFlags }
    val textFlags = remember { prefs2.textFlags }
    val context = LocalContext.current
    PreferenceLayout(label = "Debug Menu") {
        PreferenceGroup {
            ClickablePreference(
                label = "Feature Flags",
                onClick = {
                    Intent(context, SettingsActivity::class.java)
                        .putExtra(":settings:fragment", DeveloperOptionsFragment::class.java.name)
                        .also { context.startActivity(it) }
                },
            )
            ClickablePreference(
                label = "Crash Launcher",
                onClick = { throw RuntimeException("User triggered crash") },
            )
        }
        PreferenceGroup(heading = "Debug Flags") {
            flags2.forEach {
                SwitchPreference(
                    adapter = it.getAdapter(),
                    label = it.key.name
                )
            }
            flags.forEach {
                SwitchPreference(
                    adapter = it.getAdapter(),
                    label = it.key,
                )
            }
            textFlags.forEach {
                TextPreference(
                    adapter = it.getAdapter(),
                    label = it.key.name
                )
            }
        }
    }
}

private val PreferenceManager2.debugFlags: List<Preference<Boolean, Boolean>>
    get() = listOf(showComponentNames)

private val PreferenceManager2.textFlags: List<Preference<String, String>>
    get() = listOf(additionalFonts)

private fun PreferenceManager.getDebugFlags() =
    listOf(
        deviceSearch,
        searchResultShortcuts,
        searchResultPeople,
        searchResultPixelTips,
        searchResultSettings,
    )
