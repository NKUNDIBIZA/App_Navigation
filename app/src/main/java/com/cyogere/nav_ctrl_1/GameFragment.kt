package com.cyogere.nav_ctrl_1


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.cyogere.nav_ctrl_1.databinding.FragmentGameBinding

class GameFragment : Fragment() {
    //==============================================================================================
    // DATA CLASS IMPLEMENTATION
    //==============================================================================================
    data class Question(val text: String, val answers: List<String>)
    private val questions: MutableList<Question> = mutableListOf(
        Question(text = "What is Android Jetpack?",
            answers = listOf("all of these", "tools", "documentation", "libraries")),
        Question(text = "Base class for Layout?",
            answers = listOf("ViewGroup", "ViewSet", "ViewCollection", "ViewRoot")),
        Question(text = "Layout for complex Screens?",
            answers = listOf("ConstraintLayout", "GridLayout", "LinearLayout", "FrameLayout")),
        Question(text = "Pushing structured data into a Layout?",
            answers = listOf("Data Binding", "Data Pushing", "Set Text", "OnClick")),
        Question(text = "Inflate layout in fragments?",
            answers = listOf("onCreateView", "onActivityCreated", "onCreateLayout", "onInflateLayout")),
        Question(text = "Build system for Android?",
            answers = listOf("Gradle", "Graddle", "Grodle", "Groyle")),
        Question(text = "Android vector format?",
            answers = listOf("VectorDrawable", "AndroidVectorDrawable", "DrawableVector", "AndroidVector")),
        Question(text = "Android Navigation Component?",
            answers = listOf("NavController", "NavCentral", "NavMaster", "NavSwitcher")),
        Question(text = "Registers app with launcher?",
            answers = listOf("intent-filter", "app-registry", "launcher-registry", "app-launcher")),
        Question(text = "Mark a layout for Data Binding?",
            answers = listOf("<layout>", "<binding>", "<data-binding>", "<dbinding>"))
    )

    // Global variables
    lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>
    private var questionIndex = 0
    private val numQuestions = Math.min((questions.size + 1) / 2, 3)


//==============================================================================================================================================
                                     // BEGINNING OF FRAGMENT IMPLEMENTATION
//==============================================================================================================================================

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

       val binding:FragmentGameBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_game, container,false)


        randomizeQuestions()
        // Bind this fragment class to the layout
        binding.game = this
        binding.submitButton.setOnClickListener{v: View ->

            val checkedId = binding.radioGroup.checkedRadioButtonId
            // Do nothing if nothing is checked (id == -1)
            if (-1 != checkedId) {
                var answerIndex = 0
                when (checkedId) {
                    R.id.radio2 -> answerIndex = 1
                    R.id.radio3 -> answerIndex = 2
                    R.id.radio4 -> answerIndex = 3
                }
                // The first answer in the original question is always the correct one, so if our
                // answer matches, we have the correct answer.
                if (answers[answerIndex] == currentQuestion.answers[0]) {
                    questionIndex++
                    // Advance to the next question
                    if (questionIndex < numQuestions) {
                        currentQuestion = questions[questionIndex]
                        setQuestion()
                        binding.invalidateAll()
                    } else {
                        //v.findNavController().navigate(R.id.action_gameFragment_to_gameWonFragment)  // without safe args

                        //New style of navigating with safe args libraries
                        v.findNavController().navigate(GameFragmentDirections.actionGameFragmentToGameWonFragment(numQuestions, questionIndex))
                    }
                } else {
                    // Game over! A wrong answer sends us to the gameOverFragment.

                    // v.findNavController().navigate(GameFragmentDirections.actionGameFragmentToGameOverFragment())
                    v.findNavController().navigate(GameFragmentDirections.actionGameFragmentToGameOverFragment())
                }
            }

        }



        return binding.root
        }


    //===============================================================================================================================
                //Custom functions
    //===============================================================================================================================
    // randomize the questions and set the first question
    private fun randomizeQuestions() {
        questions.shuffle()
        questionIndex = 0
        setQuestion()
    }

    // Sets the question and randomizes the answers.  This only changes the data, not the UI.
    // Calling invalidateAll on the FragmentGameBinding updates the data.
    private fun setQuestion() {
        currentQuestion = questions[questionIndex]
        // randomize the answers into a copy of the array
        answers = currentQuestion.answers.toMutableList()
        // and shuffle them
        answers.shuffle()
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.test, questionIndex + 1, numQuestions)
    }

    }



