package com.example.netflixclone

import com.google.common.truth.Truth.assertThat
import org.junit.Test


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {


    /*
    * vazio
    * ser pra crianca ou nao
    * */
    @Test
    fun checkIfIsWRITE(){
        val isChild : Boolean = true
        if (isChild){
            assertThat(isChild).isTrue()
        }else{
            assertThat(isChild).isFalse()
        }
    }
}