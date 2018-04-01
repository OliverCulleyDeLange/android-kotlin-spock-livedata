package uk.co.oliverdelange.android_kotlin_spock_livedata

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.view.View
import org.junit.Rule
import spock.lang.Specification
import spock.lang.Unroll

class MainViewModelSpec extends Specification {

    @Rule
    InstantTaskExecutorRule rule = new InstantTaskExecutorRule()

    MainViewModel mainViewModel
    View mockView = Mock(View)

    void setup() {
        mainViewModel = new MainViewModel()
    }

    @Unroll
    def "Set error message to [#error] if name is [#name]"() {
        given: "No name entered"
        mainViewModel.name.value = name

        when: "Request to submit"
        mainViewModel.submit(mockView)

        then: "Error message set"
        mainViewModel.nameError.value == error

        where:
        name   | error
        "Bob" | null
        ""     | "Can not be empty"
        " "    | "Can not be empty"
        null   | "Can not be empty"
    }
}
