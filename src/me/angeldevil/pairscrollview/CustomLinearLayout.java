
package me.angeldevil.pairscrollview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

public class CustomLinearLayout extends LinearLayout {

    private static final int CHILD_PROCEED_CAN_SCROLL = 1;
    private static final int CHILD_PROCEED_CANNOT_SCROLL = -1;
    private static final int CHILD_NOT_PROCEED = 0;

    private static final int MAX_DEPTH = 4;
    
    public CustomLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean canScrollVertically(int direction) {
        int ret = transerseChild(this, direction, 1);
        if (ret == CHILD_PROCEED_CAN_SCROLL) {
            return true;
        } else if (ret == CHILD_PROCEED_CANNOT_SCROLL) {
            return false;
        }
        return super.canScrollVertically(direction);
    }

    private int transerseChild(ViewGroup parent, int direction, int currentDepth) {
        int count = parent.getChildCount();
        for (int i = 0; i < count; i++) {
            View child = parent.getChildAt(i);
            if (child instanceof ListView) {
                ListView list = (ListView) child;
                return list.canScrollVertically(direction) ? CHILD_PROCEED_CAN_SCROLL : CHILD_PROCEED_CANNOT_SCROLL;
            } else if (child instanceof ViewGroup && currentDepth <= MAX_DEPTH) {
                int ret = transerseChild((ViewGroup) child, direction, ++currentDepth);
                if (ret != CHILD_NOT_PROCEED) {
                    return ret;
                }
            }
        }
        return CHILD_NOT_PROCEED;
    }

    @Override
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
//        super.requestDisallowInterceptTouchEvent(disallowIntercept);
    }
}
