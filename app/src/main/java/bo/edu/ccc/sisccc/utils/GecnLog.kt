package bo.edu.ccc.sisccc.utils

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

    }
}