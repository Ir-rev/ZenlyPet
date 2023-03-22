package ir.rev.map

interface MapContract {

    /**
     * есть ли права на работы с "грубой" геопозицией
     */
    abstract val hasRowGeoPermission: Boolean

    /**
     * есть ли права на работы с "с точной" геопозицией
     */
    abstract val hasFineGeoPermission: Boolean

    /** запрос на получение прав на гео */
    fun getGeoPermissions()

    /** запрос на получение текущей геолокации */
    fun getGeo()


    /** интерфейс для фрагмента карты*/
    interface Handler {

        fun setGeo(latitude: Double, longitude: Double)


    }
}