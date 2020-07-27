package vn.edu.ntu.vancuong.baithi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.edu.ntu.vancuong.baithi.controller.IController;
import vn.edu.ntu.vancuong.baithi.model.ThongTin;

public class DanhsachFragment extends Fragment {

    IController controller;
    NavController navController;
    private Toolbar mTbds;
    private RecyclerView mRvds;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_danhsach, container, false);
        addview(view);
        addevent();
        return view;
    }

    private void addevent() {
        mTbds.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                if(id == R.id.mnuadd)
                {
                    navController.navigate(R.id.action_danhsachFragment_to_addFragment);
                }
                return false;
            }
        });
    }

    private void addview(View view) {
        mTbds = view.findViewById(R.id.tbds);
        mRvds = view.findViewById(R.id.rvds);

        controller = ((MainActivity)getActivity()).controller;
        navController = NavHostFragment.findNavController(DanhsachFragment.this);

        mTbds.inflateMenu(R.menu.my_menu);
        mRvds.setLayoutManager(new LinearLayoutManager(DanhsachFragment.this.getActivity()));
        ThongtinAdapter adapter = new ThongtinAdapter(controller.getAllThongTin());
        mRvds.setAdapter(adapter);
    }

    private class ThongtinViewHolder extends RecyclerView.ViewHolder
    {

        //khai bao cac bien trong 1 thanh phan viewholder(phan tu lap di lap lai) cua adapter

        TextView txthienthi;
        public ThongtinViewHolder(@NonNull View itemView) {
            super(itemView);
            txthienthi = itemView.findViewById(R.id.txtht);

        }

        public void bind(ThongTin p)
        {
            txthienthi.setText("Môn học: "+ p.getMonhoc() + "\n Ngày bắt đầu: " + p.getNgaybd() + "\nNgày dự kiến kết thúc: "
                    +p.getNgaykt() + "\nGiảng đường" + p.getGiangduong() + "\nHình thức:  " + p.getHinhthuc());
            //truyen du lieu vao cac thanh phan trong viewholder tu list trong adater--
        }
    }

    private class ThongtinAdapter extends RecyclerView.Adapter<ThongtinViewHolder>
    {
        List<ThongTin> listThongtin;

        public ThongtinAdapter(List<ThongTin> listThongtin) {
            this.listThongtin = listThongtin;
        }


        @NonNull
        @Override
        public DanhsachFragment.ThongtinViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.thongtin, parent, false);
            return new ThongtinViewHolder(view);

        }

        @Override
        public void onBindViewHolder(@NonNull DanhsachFragment.ThongtinViewHolder holder, int position) {
            holder.bind(listThongtin.get(position));
        }

        @Override
        public int getItemCount() {
            return listThongtin.size();
        }
    }
}