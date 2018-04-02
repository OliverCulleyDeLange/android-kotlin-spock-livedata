package uk.co.oliverdelange.android_kotlin_spock_livedata

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.view.View
import de.jodamob.kotlin.testrunner.SpotlinTestRunner
import org.junit.Rule
import org.junit.runner.RunWith
import spock.lang.Specification
import spock.lang.Unroll

@RunWith(SpotlinTestRunner)
class MainViewModelSpec2 extends Specification {

    @Rule
    InstantTaskExecutorRule rule = new InstantTaskExecutorRule()

    MainViewModel mainViewModel
    View dummyView = Mock(View)

    void setup() {
        mainViewModel = new MainViewModel()
    }

    @Unroll
    def "Duplicate test to show bug"() {
        given: "No name entered"
        mainViewModel.name.value = name

        when: "Request to submit"
        mainViewModel.submit(dummyView)

        then: "Error message set"
        mainViewModel.nameError.value == error

        where:
        name  | error
        "Bob" | null
        ""    | "Can not be empty"
        " "   | "Can not be empty"
        null  | "Can not be empty"
    }
}
