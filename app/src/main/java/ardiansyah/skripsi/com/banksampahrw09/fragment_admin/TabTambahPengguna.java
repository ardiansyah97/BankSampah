package ardiansyah.skripsi.com.banksampahrw09.fragment_admin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ardiansyah.skripsi.com.banksampahrw09.R;

/**
 * Created by Ardiansyah on 15/09/2017.
 */

public class TabTambahPengguna extends Fragment {

    public TabTambahPengguna(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_tambah_pengguna, container, false);
    }
}
