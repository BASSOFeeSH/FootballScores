package barqsoft.footballscores.service;

import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViewsService;

import barqsoft.footballscores.ScoreViewsFactory;

public class WidgetService extends RemoteViewsService
{
    public static String LOG_TAG = "WidgetService";
    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent)
    {
        Log.d(LOG_TAG, "Widget Service onGetViewFactory");
        return (new ScoreViewsFactory(this.getApplicationContext(),
                                      intent));
    }
}
