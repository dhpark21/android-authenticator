/*
 * Copyright (c) 2025 Proton AG
 * This file is part of Proton AG and Proton Authenticator.
 *
 * Proton Authenticator is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Proton Authenticator is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Proton Authenticator.  If not, see <https://www.gnu.org/licenses/>.
 */

package proton.android.authenticator.features.settings.master.presentation

import proton.android.authenticator.protonapps.domain.ProtonApp
import proton.android.authenticator.protonapps.domain.ProtonAppType
import proton.android.authenticator.shared.common.domain.builds.BuildFlavorType
import proton.android.authenticator.shared.common.domain.configs.AppConfig

internal data class SettingsMasterBannerModel(
    private val isPassBannerDismissed: Boolean,
    private val uninstalledProtonApps: List<ProtonApp>,
    private val appConfig: AppConfig
) {

    internal val shouldShowPassBanner: Boolean
        get() = !isPassBannerDismissed && uninstalledProtonApps.any {
            if (appConfig.buildFlavor.type == BuildFlavorType.Fdroid)
                it.type == ProtonAppType.PassFDroid
            else
                it.type == ProtonAppType.Pass
        }

    internal val passBannerApp: ProtonApp = ProtonApp(
        type = if (appConfig.buildFlavor.type == BuildFlavorType.Fdroid)
            ProtonAppType.PassFDroid
        else
            ProtonAppType.Pass,
        isInstalled = false
    )

}
