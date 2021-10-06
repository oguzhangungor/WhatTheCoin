package com.ogungor.whatthecoin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ExpandableListView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.ogungor.whatthecoin.util.extentions.launchMainToSearchActivity

class MainActivity : AppCompatActivity() {

    private lateinit var listViewAdapter: ExpandableListViewAdapter
    private lateinit var chapterList: List<String>
    private lateinit var topicList: HashMap<String,List<String>>
    private lateinit var eListView:ExpandableListView

    private lateinit var searchButton: FloatingActionButton




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        eListView=findViewById(R.id.eListView)
        searchButton=findViewById(R.id.seachActionButton)

        showList()

        listViewAdapter=ExpandableListViewAdapter(this,chapterList,topicList)
        eListView.setAdapter(listViewAdapter)

        eListView.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
            when (groupPosition)
            {
                0->{
                    when(childPosition)
                    {
                        0->{
                            showToast(groupPosition,childPosition)

                        }
                        1->{
                            showToast(groupPosition,childPosition)


                        }
                        2->{
                            showToast(groupPosition,childPosition)

                        }
                        3->{
                            showToast(groupPosition,childPosition)


                        }
                        4->{
                            showToast(groupPosition,childPosition)

                        }
                    }
                }
                1->{
                    when(childPosition)
                    {
                        0->{
                            showToast(groupPosition,childPosition)

                        }
                        1->{
                            showToast(groupPosition,childPosition)


                        }
                        2->{
                            showToast(groupPosition,childPosition)

                        }
                        3->{
                            showToast(groupPosition,childPosition)


                        }
                        4->{
                            showToast(groupPosition,childPosition)

                        }
                    }

                }
                2->{

                    when(childPosition)
                    {
                        0->{
                            showToast(groupPosition,childPosition)

                        }
                        1->{
                            showToast(groupPosition,childPosition)


                        }
                        2->{
                            showToast(groupPosition,childPosition)

                        }
                        3->{
                            showToast(groupPosition,childPosition)


                        }
                        4->{
                            showToast(groupPosition,childPosition)

                        }
                    }
                }
                3->
                { when(childPosition)
                {
                    0->{
                        showToast(groupPosition,childPosition)

                    }
                    1->{
                        showToast(groupPosition,childPosition)


                    }
                    2->{
                        showToast(groupPosition,childPosition)

                    }
                    3->{
                        showToast(groupPosition,childPosition)


                    }
                    4->{
                        showToast(groupPosition,childPosition)

                    }
                }
                }
            }
            System.err.println("child clicked")
            true
        }

        searchButton.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
               launchMainToSearchActivity()
            }



        })

    }
    fun showToast(groupPosition:Int,childPosition:Int){

        val groupP =groupPosition+ 1
        val chilps= childPosition+1
        Toast.makeText(applicationContext,
            "child clicked $groupP. Group $chilps. Sıra", Toast.LENGTH_LONG).show()


    }



    private fun showList() {
        chapterList=ArrayList()
        topicList= HashMap()

        for (i in 1..5)
        {
            (chapterList as ArrayList<String>).add("Grup $i ")
        }



        val topic1: MutableList<String> = ArrayList()
        for (i in 1..5)
        {
            topic1.add("Sıra $i")
        }


        val topic2:MutableList<String> = ArrayList()

        for (i in 1..5)
        {
            topic2.add("Sıra $i")
        }

        val topic3: MutableList<String> = ArrayList()

        for (i in 1..5)
        {
            topic3.add("Sıra $i")
        }


        val topic4: MutableList<String> = ArrayList()

        for (i in 1..5)
        {
            topic4.add("Sıra $i")
        }


        val topic5: MutableList<String> = ArrayList()

        for (i in 1..5)
        {
            topic5.add("Sıra $i")
        }


        topicList[chapterList[0]]=topic1
        topicList[chapterList[1]]=topic2
        topicList[chapterList[2]]=topic3
        topicList[chapterList[3]]=topic4
        topicList[chapterList[4]]=topic5

    }
}