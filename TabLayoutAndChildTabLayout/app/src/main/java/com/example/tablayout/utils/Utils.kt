package com.example.tablayout.utils

import kotlin.concurrent.thread

class Utils {
    private fun classicIO(block: () -> Unit) {
        thread {
            block
        }
    }

}