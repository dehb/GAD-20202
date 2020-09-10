package com.dehb.leaderboard

import android.app.AlertDialog
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.ContextThemeWrapper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import kotlinx.android.synthetic.main.fragment_submission_form.*
import kotlinx.android.synthetic.main.fragment_submission_form.view.*
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create


class SubmissionForm : Fragment() {
    private val viewModel: ViewModel by activityViewModels()

   lateinit var first_name: String
    lateinit var last_name: String
    lateinit var email_id: String
    lateinit var github_link: String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root =  inflater.inflate(R.layout.fragment_submission_form, container, false)
        root.back.setOnClickListener {
            popUp()
        }
  root.submit.setOnClickListener {
       first_name = firstName.text.toString().trim()
       last_name = lastName.text.toString().trim()
      email_id = email.text.toString().trim()
      github_link = github.text.toString().trim()

      if(first_name.isEmpty() || last_name.isEmpty() || email_id.isEmpty() || github_link.isEmpty()) {
          Toast.makeText(requireContext(), "Please fill up all fields", Toast.LENGTH_LONG).show()
          return@setOnClickListener
      }
      showConfirmAlert()
  }
        return root
    }

    private fun popUp() {

        requireActivity().supportFragmentManager.popBackStack()
    }

    private fun showConfirmAlert() {

    val dialogView: View = LayoutInflater.from(requireContext()).inflate(R.layout.submit_confirmation, null, false)
    val close = dialogView.findViewById<ImageView>(R.id.close)
    val accept = dialogView.findViewById<Button>(R.id.accept)

    val dialogBuilder = AlertDialog.Builder(requireContext())
    dialogBuilder.setView(dialogView)
        val alertDialog: AlertDialog = dialogBuilder.create()
        alertDialog.setCancelable(false)
    alertDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alertDialog.show()

        close.setOnClickListener {
              alertDialog.dismiss()
        }
            accept.setOnClickListener {
            submitData(first_name,last_name,email_id,github_link)
          alertDialog.dismiss()
        }

     }

    private fun submitData(firstName:String, lastName:String, email:String, github:String) {
    val service = RetrofitFactory.getRetrofitInstanceForm().create(ApiInterface:: class.java)
        service.submitProject(firstName,lastName,email,github).enqueue(object : Callback<Void> {

            override fun onResponse(call: retrofit2.Call<Void>, response: Response<Void>) {
                showSuccessAlert()
                Toast.makeText(requireContext(),"Data Submitted",Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: retrofit2.Call<Void>, t: Throwable) {
                showFailureAlert()
                Toast.makeText(requireContext(),"Data not Submitted",Toast.LENGTH_SHORT).show()
            }

        })
    }

    private fun showSuccessAlert() {
        val dialogBuilder = AlertDialog.Builder(requireContext())
        dialogBuilder.setView(View.inflate(requireContext(), R.layout.submit_success, null))
        val alertDialog: AlertDialog = dialogBuilder.create()

        alertDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alertDialog.show()
    }

    private fun showFailureAlert() {
        val dialogBuilder = AlertDialog.Builder(requireContext())
        dialogBuilder.setView(View.inflate(requireContext(), R.layout.submit_failure, null))
        val alertDialog: AlertDialog = dialogBuilder.create()

        alertDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alertDialog.show()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }
}