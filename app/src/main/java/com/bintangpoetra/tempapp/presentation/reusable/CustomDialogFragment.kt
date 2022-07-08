package com.bintangpoetra.tempapp.presentation.reusable

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.DialogFragment
import com.bintangpoetra.tempapp.R
import com.bintangpoetra.tempapp.utils.BundleKeys

class CustomDialogFragment : DialogFragment() {

    private var title: String? = null
    private var description: String? = null
    private var imageResourceId: Int? = null
    private var negativeButton: String? = null
    private var positiveButton: String? = null

    private lateinit var imgIcon: ImageView

    private lateinit var tvTitle: TextView
    private lateinit var tvDescription: TextView

    private lateinit var btnNegative: AppCompatButton
    private lateinit var btnPositive: AppCompatButton

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(
            title: String,
            description: String,
            @DrawableRes imageResourceId: Int,
            negativeButton: String,
            positiveButton: String
        ) =
            CustomDialogFragment().apply {
                arguments = Bundle().apply {
                    putString(BundleKeys.TITLE_BUNDLE_KEY, title)
                    putString(BundleKeys.DESCRIPTION_BUNDLE_KEY, description)
                    putInt(BundleKeys.IMAGE_KEY, imageResourceId)
                    putString(BundleKeys.NEGATIVE_BUTTON, negativeButton)
                    putString(BundleKeys.POSITIVE_BUTTON, positiveButton)
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            title = it.getString(BundleKeys.TITLE_BUNDLE_KEY)
            description = it.getString(BundleKeys.DESCRIPTION_BUNDLE_KEY)
            imageResourceId = it.getInt(BundleKeys.IMAGE_KEY)
            negativeButton = it.getString(BundleKeys.NEGATIVE_BUTTON)
            positiveButton = it.getString(BundleKeys.POSITIVE_BUTTON)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_custom_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI(view)
        initAction()
        initData()
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }

    private fun initUI(view: View) {
        imgIcon = view.findViewById(R.id.img_dialog_icon)
        tvTitle = view.findViewById(R.id.tv_title)
        tvDescription = view.findViewById(R.id.tv_description)

        btnNegative = view.findViewById(R.id.btn_negative)
        btnPositive = view.findViewById(R.id.btn_positive)
    }

    private fun initAction() {
        btnPositive.setOnClickListener {
            dismiss()
        }
        btnNegative.setOnClickListener {
            dismiss()
        }
    }

    private fun initData() {
        tvTitle.text = title
        tvDescription.text = description
        btnNegative.text = negativeButton
        btnPositive.text = positiveButton
        imageResourceId?.let { imgIcon.setImageResource(it) }
    }
}