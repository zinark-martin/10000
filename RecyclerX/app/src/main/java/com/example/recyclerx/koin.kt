package com.example.recyclerx

import org.koin.core.qualifier.named
import org.koin.dsl.module

val girlModule = module {
    //每次都是新的
    factory {
        Girl()
    }
}
val girlSingleModule = module {
    single {
        Girl()
    }
    factory(named("123")) {
        Girl()
    }
}
val girlsModule = module {
    //named:string类型的限定词
    single(named("one")) { (name:String) ->
        Girl().also {
            it.name = name
        }
    }
    single(named("two")) {(name:String) ->
        Girl().also {
            it.name = name
        }
    }
}
val girlModuleScope = module {
    scope(named("scope")) {
        scoped {
            Girl()
        }
    }
}