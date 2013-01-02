package com.barcicki.gorcalculator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.barcicki.gorcalculator.core.Player;
import com.barcicki.gorcalculator.dummy.DummyContent;

public class PlayerDetailFragment extends Fragment {

	public static final String ARG_ITEM_ID = "item_id";

	Player mItem;

	public PlayerDetailFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments().containsKey(ARG_ITEM_ID)) {
			mItem = DummyContent.ITEM_MAP.get(getArguments().getString(
					ARG_ITEM_ID));
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_player,
				container, false);
		if (mItem != null) {
			((TextView) rootView.findViewById(R.id.playerName))
					.setText(mItem.toString());
		}
		return rootView;
	}
}