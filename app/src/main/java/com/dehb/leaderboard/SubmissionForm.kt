package com.dehb.leaderboard

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import kotlinx.android.synthetic.main.fragment_submission_form.*
import kotlinx.android.synthetic.main.fragment_submission_form.view.*


class SubmissionForm : Fragment() {
    private val viewModel: ViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root =  inflater.inflate(R.layout.fragment_submission_form, container, false)
  root.submit.setOnClickListener {
      val firstName = firstName.text.toString().trim()
      val lastName = lastName.text.toString().trim()
      val email = email.text.toString().trim()
      val github = github.text.toString().trim()

      if(firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || github.isEmpty()) {
          Toast.makeText(requireContext(), "Please fill up all fields", Toast.LENGTH_LONG).show()
          return@setOnClickListener
      }
//      buildAlert()
  }
        return root
    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }
}