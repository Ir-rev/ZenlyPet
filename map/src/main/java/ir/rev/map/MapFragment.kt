package ir.rev.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.fragment.app.Fragment
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.runtime.image.ImageProvider
import ir.rev.map.databinding.FragmentMapBinding
import ir.rev.map_repository.MapRepositoryPlugin

internal class MapFragment : Fragment(), MapContract.Handler {

    private lateinit var binding: FragmentMapBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MapPlugin.setMapApiKey()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMapBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        MapKitFactory.initialize(requireContext())
    }

    override fun onStart() {
        super.onStart()
        binding.map.onStart()
        MapKitFactory.getInstance().onStart()
    }

    override fun onResume() {
        super.onResume()
        (parentFragment as? MapContract)?.getGeoPermissions()
    }

    override fun onStop() {
        binding.map.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }

    companion object {
        fun newInstance() = MapFragment()
    }

    override fun setGeo(latitude: Double, longitude: Double) {
        binding.map.map.apply {
            move(
                CameraPosition(
                    Point(latitude, longitude), 11f, 0f, 0f
                )
            )
            mapObjects.addPlacemark(
                Point(latitude, longitude),
                ImageProvider.fromBitmap(
                    ContextCompat.getDrawable(requireContext(), R.drawable.ic_baseline_gpp_good_24)?.toBitmap()
                )
            )
        }
        MapRepositoryPlugin.getMapRepository().uploadGeo(latitude, longitude)
    }
}
