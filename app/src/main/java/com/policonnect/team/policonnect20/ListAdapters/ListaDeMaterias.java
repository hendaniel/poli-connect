package com.policonnect.team.policonnect20.ListAdapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.policonnect.team.policonnect20.Objects.Subject;
import com.policonnect.team.policonnect20.R;

import java.util.ArrayList;

public class ListaDeMaterias extends BaseExpandableListAdapter {

    private Context context;
    private static ArrayList<Subject>[] listData;
    private final String[] daysNames = new String[]{"Lunes", "Martes", "Miercoles", "Jueves",
            "Viernes", "Sábado"};
    private final String[] hourStrings = new String[]{"7:00 - 8:30", "8:40 - 10:10",
            "10:20 - 11:50", "12:00 - 13:30", "13:40 - 15:10", "15:20 - 16:50", "17:00 - 18:30",
            "18:40 - 20:10", "20:20 - 21:50"};

    public ListaDeMaterias(Context context, ArrayList<Subject>[] listData) {
        this.context = context;
        ListaDeMaterias.listData = listData;
    }

    @Override
    public int getGroupCount() {
        return listData.length;
    }

    @Override
    public int getChildrenCount(int dayOfWeek) {
        return listData[dayOfWeek].size();
    }

    @Override
    public Object getGroup(int dayOfWeek) {
        return listData[dayOfWeek];
    }

    @Override
    public Object getChild(int dayOfWeek, int hour) {
        return listData[dayOfWeek].get(hour);
    }

    @Override
    public long getGroupId(int dayOfWeek) {
        return dayOfWeek;
    }

    @Override
    public long getChildId(int dayOfWeek, int hour) {
        return dayOfWeek * 10 + hour;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int dayOfWeek, boolean isExpanded, View view, ViewGroup parent) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_usuario_schedule_group, null);
        }

        TextView dayOfTheWeek = view.findViewById(R.id.dayOfTheWeek);

        dayOfTheWeek.setText(daysNames[dayOfWeek]);
        return view;
    }

    @Override
    public View getChildView(int dayOfWeek, int index, boolean isLastChild, View view, ViewGroup parent) {
        final String subjectName = listData[dayOfWeek].get(index).getName();
        final String subjectClassRoom = listData[dayOfWeek].get(index).getClassRoom();

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_usuario_schedule_child, null);
        }

        TextView mSubjectName = view.findViewById(R.id.subjectName);
        TextView mSubjectClassRoom = view.findViewById(R.id.subjectClassRoom);
        TextView mSubjectHour = view.findViewById(R.id.subjectHour);

        mSubjectName.setText(subjectName);
        mSubjectClassRoom.setText(subjectClassRoom);
        mSubjectHour.setText(hourStrings[listData[dayOfWeek].get(index).getTime()]);
        return view;
    }

    @Override
    public boolean isChildSelectable(int dayOfWeek, int hour) {
        return false;
    }

}
