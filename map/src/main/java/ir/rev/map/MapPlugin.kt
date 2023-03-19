package ir.rev.map

import androidx.fragment.app.Fragment
import com.yandex.mapkit.MapKitFactory

/**
 * предаставляет зависимости для работы с модулем карты
 */
object MapPlugin {

    private var isMapApiKeyInstalled = false

    /** возвращаем экземпляр фрагмента карты */
    fun getMapFragment(): Fragment = MapFragment.newInstance()

    /** устанавливает ключ для работы с картой */
    fun setMapApiKey() {
        isMapApiKeyInstalled = true
        MapKitFactory.setApiKey("fbedf253-78bd-465a-8980-ffb2a26f88ce")
    }
}