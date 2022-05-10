package edu.sjsu.android.Points;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import edu.sjsu.android.Points.placeholder.PlaceholderContent;

/**
 * A fragment representing a list of Items.
 */
public class SceneryFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public SceneryFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static SceneryFragment newInstance(int columnCount) {
        SceneryFragment fragment = new SceneryFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_scenery_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            ArrayList<PlaceholderContent> placeholderContents = new ArrayList<>();

            placeholderContents.add(new PlaceholderContent(".Stanford University",
                    "Address:450 Serra Mall, Stanford, CA 94305",
                    "Description: Stanford University, officially Leland Stanford Junior University, is a private research university located in the census-designated place of Stanford, California, near the city of Palo Alto. The campus occupies 8,180 acres, among the largest in the United States, and enrolls over 17,000 students.",
                    R.mipmap.stanford_university));
            placeholderContents.add(new PlaceholderContent("University of California, Berkeley",
                    "Address: UC Berkeley110 Sproul Hall #5800Berkeley, CA 94720",
                    "Description: The University of California, Berkeley is a public land-grant research university in Berkeley, California. Established in 1868 as the University of California, it is the state's first land-grant university and the first campus of the University of California system.",
                    R.mipmap.uc_berkeley));
            placeholderContents.add(new PlaceholderContent("Apple Apple Park Visitor Center",
                    "Address:10600 N Tantau Ave, Cupertino, CA 95014","Description: Apple retail store selling iPhones, iPads & more in sleekly designed spaces.\n" +
                    "Service options:In-store shopping·Curbside pickup·Delivery",
                    R.mipmap.apple_apple_park_visitor_center));
            placeholderContents.add(new PlaceholderContent("Googleplex",
                    "Address:1600 Amphitheatre Pkwy, Mountain View, CA 94043",
                    "Description: The Googleplex is the corporate headquarters complex of Google and its parent company, Alphabet Inc. It is located at 1600 Amphitheatre Parkway in Mountain View, California.",
                    R.mipmap.googleplex));
            placeholderContents.add(new PlaceholderContent("Golden Gate Bridge",
                    "Address:Golden Gate Bridge, San Francisco, CA",
                    "Description:The Golden Gate Bridge is a suspension bridge spanning the Golden Gate, the one-mile-wide strait connecting San Francisco Bay and the Pacific Ocean.",
                    R.mipmap.golden_gate_bridge));
            placeholderContents.add(new PlaceholderContent(".San jose state university",
                    "Address:1 Washington Sq, San Jose, CA 95192",
                    "Description: San José State University is a public university in San Jose, California. SJSU is the oldest public university on the West Coast and the founding campus of the California State University system. Located in downtown San Jose, the SJSU main campus is situated on 154 acres, or roughly 19 square blocks.",
                    R.mipmap.san_jose_university));
            recyclerView.setAdapter(new MyItemRecyclerViewAdapter(placeholderContents));
        }
        return view;
    }
}