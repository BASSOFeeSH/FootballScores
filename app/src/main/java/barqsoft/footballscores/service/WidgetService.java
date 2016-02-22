package barqsoft.footballscores.service;

import android.content.Intent;
import android.widget.RemoteViewsService;

import barqsoft.footballscores.ScoreViewsFactory;

public class WidgetService extends RemoteViewsService
{
    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent)
    {
        return (new ScoreViewsFactory(this.getApplicationContext(),
                                      intent));
    }
}
