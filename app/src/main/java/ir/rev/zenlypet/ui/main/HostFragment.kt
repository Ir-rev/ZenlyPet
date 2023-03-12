package ir.rev.zenlypet.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import ir.rev.map.MapPlugin
import ir.rev.zenlypet.R
import ir.rev.zenlypet.auth.AuthPlugin
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HostFragment : Fragment() {

    companion object {
        fun newInstance() = HostFragment()
    }

    private lateinit var viewModel: HostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[HostViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_host, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch(Dispatchers.Default) {
            viewModel.actions.collect {
                when (it) {
                    HostViewModel.Action.OpenAuthScreen -> replaceFragment(AuthPlugin.getAuthFragment())
                    HostViewModel.Action.OpenMainScreen -> replaceFragment(MapPlugin.getMapFragment())
                }
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        childFragmentManager.beginTransaction().replace(R.id.container, fragment).addToBackStack(null).commit()
    }

}