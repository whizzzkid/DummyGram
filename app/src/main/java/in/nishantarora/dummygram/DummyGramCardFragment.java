package in.nishantarora.dummygram;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.GestureDetectorCompat;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


public class DummyGramCardFragment extends Fragment {

    private static final String TAG = "DummyGram Fragment";
    private static String IMAGE_URI = "IMGURI";
    private String imageUri;
    private GestureDetectorCompat gestureDetectorCompat;
    private ImageButton heartButton;
    private ImageView imageView;
    private boolean nextCardLoaded;

    public DummyGramCardFragment() {
        // Required empty public constructor
    }

    public static DummyGramCardFragment newInstance(String imageURI) {
        Log.v(TAG, imageURI);
        DummyGramCardFragment fragment = new DummyGramCardFragment();
        Bundle args = new Bundle();
        args.putString(IMAGE_URI, imageURI);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imageUri = getArguments().getString(IMAGE_URI);
        nextCardLoaded = false;
        gestureDetectorCompat = new GestureDetectorCompat(getContext(), new DoubleClickListener());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dummy_gram_card,
                container, false);
        heartButton = (ImageButton) view.findViewById(R.id.heartButton);
        imageView = (ImageView) view.findViewById(R.id.imageView);
        Picasso.with(getContext())
                .load(imageUri)
                .placeholder(R.drawable.ic_camera_black_250dp)
                .resize(1500, 1500)
                .centerInside()
                .noFade()
                .into(imageView);
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetectorCompat.onTouchEvent(event);
                return false;
            }
        });
        return view;
    }

    private class DoubleClickListener extends GestureDetector.SimpleOnGestureListener{

        private static final String DEBUG_TAG = "Gestures";

        @Override
        public boolean onDoubleTapEvent(MotionEvent event) {
            if (!nextCardLoaded) {
                nextCardLoaded = true;
                heartButton.setVisibility(View.VISIBLE);
                Handler handler = new Handler();
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        ((DummyGram) getActivity()).setNextItem();
                    }
                };
                handler.postDelayed(runnable, 350);
                return true;
            }
            return false;
        }
    }
}
