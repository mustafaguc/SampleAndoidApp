package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.google.android.material.snackbar.Snackbar
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val subscribe = RestAPI.userService()
            .randomUsers()
            .applySchedulers()
            .doOnSubscribe {
                Snackbar.make(findViewById(android.R.id.content), "Loading", Snackbar.LENGTH_LONG).show();
            }
            .subscribe {
//                it.results.forEach(System.out::println)
                setContent {
                    MyApplicationTheme {
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                            color = MaterialTheme.colorScheme.background
                        ) {
                            setUsers(it.results)
                        }
                    }
                }
            }.also {
                Toast.makeText(this, "Merhaba dünya", Toast.LENGTH_LONG).show()
            }

        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android Developer 10")
                }
            }
        }
    }
}

@Composable
fun setUsers(users: List<User>) {
    Column {
        users.map{
            Text(it.email)
        }
    }
//    Text(users.joinToString(separator = "\\n ") { it.toString() })
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

fun <T : Any> Observable<T>.applySchedulers(): Observable<T> {
    observeOn(Schedulers.io()).subscribeOn(AndroidSchedulers.mainThread())
    return this
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android Developer")
    }
}