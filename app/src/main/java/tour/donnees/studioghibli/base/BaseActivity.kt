package tour.donnees.studioghibli.base

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity: AppCompatActivity() {

    abstract fun observerNetworkState()

}