package ir.rev.zenlypet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.rev.zenlypet.ui.main.HostFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, HostFragment.newInstance())
                .commitNow()
        }
    }
}