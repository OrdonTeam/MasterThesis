package com.helloordon.hellokotlin.write

import java.io.File
import java.io.FileOutputStream

fun File.appendingOutputStream(): FileOutputStream {
    return FileOutputStream(this, true)
}

fun File.clear() {
    this.writer().use {  }
}
