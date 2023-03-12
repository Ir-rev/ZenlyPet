package ir.rev.zenlypet.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.rev.zenlypet.auth.AuthPlugin
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class HostViewModel : ViewModel() {

    private val _actions = MutableSharedFlow<Action>()
    val actions: SharedFlow<Action> = _actions

    init {
        viewModelScope.launch {
            _actions.emit(
                if (AuthPlugin.isUserAuth()) {
                    Action.OpenMainScreen
                } else {
                    Action.OpenAuthScreen
                }
            )
        }
    }

    sealed class Action {
        object OpenAuthScreen : Action()
        object OpenMainScreen : Action()
    }

}