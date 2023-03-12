package ir.rev.map

import androidx.fragment.app.Fragment

/**
 * предаставляет зависимости для работы с модулем карты
 */
object MapPlugin {

    /** возвращаем экземпляр фрагмента карты */
    fun getMapFragment(): Fragment = MapFragment.newInstance()
}