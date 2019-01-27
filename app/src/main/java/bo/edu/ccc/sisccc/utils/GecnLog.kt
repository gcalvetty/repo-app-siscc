package bo.edu.ccc.sisccc.utils

import bo.edu.ccc.sisccc.BuildConfig
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy

class GecnLog {
    private var NAME = "APP_SIS_CCC"
    init {
        val formatStrategy = PrettyFormatStrategy.newBuilder()
            //.showThreadInfo(false)
            //.logStrategy(customLog)
            .methodCount(1)
            .methodOffset(6)
            .tag(NAME)
            .build()
        // -----
        Logger.addLogAdapter(object: AndroidLogAdapter(formatStrategy){
            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return BuildConfig.DEBUG_MODE
            }
        })

    }
    companion object {
        private var instance: GecnLog? = null
        fun d(message: String){
            iniciarLog()
            Logger.d(message)
        }
        fun v(message: String){
            iniciarLog()
            Logger.v(message)
        }

        private fun iniciarLog(){
            if(instance == null ){
                instance = GecnLog()
            }
        }
    }
}