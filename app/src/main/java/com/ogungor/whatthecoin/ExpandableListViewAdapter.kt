package com.ogungor.whatthecoin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView

class ExpandableListViewAdapter : BaseExpandableListAdapter {

    private lateinit var context: Context
    private lateinit var chapterList:List<String>
    private lateinit var topicsList:HashMap<String,List<String>>

    constructor(
        context: Context,
        chapterList: List<String>,
        topicsList: HashMap<String, List<String>>
    ) : super() {
        this.context = context
        this.chapterList = chapterList
        this.topicsList = topicsList
    }


    override fun getGroupCount(): Int {
       return this.chapterList.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
       return this.topicsList[this.chapterList[groupPosition]]!!.size
    }

    override fun getGroup(groupPosition: Int): Any {
       return this.chapterList.get(groupPosition)
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
       return this.topicsList[this.chapterList[groupPosition]]!![childPosition]
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View {
        var chapterTitle= getGroup(groupPosition) as String
        var convertView=convertView

        if (convertView==null)
        {
            val inflater= context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.chapter_list,null)

        }

        val chapterTv = convertView!!.findViewById<TextView>(R.id.chapter_tv)
        chapterTv.setText(chapterTitle)

        return convertView
    }

    override fun getChildView(groupPosition: Int, childPosition: Int,isLastChild: Boolean, convertView: View?, parent: ViewGroup?): View {

        var topicTitle= getChild(groupPosition,childPosition) as String
        var convertView=convertView

        if (convertView==null)
        {
            val inflater= context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.topics_list,null)

        }

        val topicTv = convertView!!.findViewById<TextView>(R.id.topics_tv)
        topicTv.setText(topicTitle)

        return convertView
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
       return true
    }
}