package com.example.fragmets

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class SecondFragment:Fragment() {
    private var btnRemove:Button?=null
    private var listener:FragmentListener?=null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener=context as FragmentListener
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_two,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnRemove=view.findViewById(R.id.btnRemove)

        btnRemove?.setOnClickListener {
            listener?.removeFragment()
        }
    }

}