package com.example.hp.individual;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<UserModel> userModelArrayList;

    public CustomAdapter(Context context,ArrayList<UserModel> userModelArrayList){

        this.context = context;
        this.userModelArrayList = userModelArrayList;
    }

    @Override
    public int getCount() {

        return userModelArrayList.size();
    }

    @Override
    public Object getItem(int position) {

        return userModelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {

        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null)
        {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_lvitem, null, true);
            holder.tvname = (TextView) convertView.findViewById(R.id.DateView);
            holder.tvcountry = (TextView) convertView.findViewById(R.id.DrugView);
            holder.t1 = (TextView) convertView.findViewById(R.id.SymptonView);
            holder.t2 = (TextView) convertView.findViewById(R.id.TreatmentView);

            convertView.setTag(holder);

        }
        else
            {
                holder = (ViewHolder) convertView.getTag();
            }

                ///////////////////Veiw page////////////////////////////////////////////////////////////
            holder.tvname.setText("วันที่: " + userModelArrayList.get(position).getDate());
            holder.tvcountry.setText("การใช้ยา: " + userModelArrayList.get(position).getDrug());
            holder.t1.setText("อาการ: " + userModelArrayList.get(position).getSymtop());
            holder.t2.setText("ปฐมพยาบาลเบื้องต้น: " + userModelArrayList.get(position).getTreatment());

            return convertView;

    }

    private class ViewHolder {

        protected TextView tvname, tvcountry,t1,t2;

    }
}
