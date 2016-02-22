package barqsoft.footballscores;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;

import barqsoft.footballscores.service.WidgetService;

/**
 * Implementation of App Widget functionality.
 */
public class AppWidget extends AppWidgetProvider {
    public static String EXTRA_WORD=
            "com.commonsware.android.appwidget.lorem.WORD";

    @Override
    public void onUpdate(Context ctxt, AppWidgetManager appWidgetManager,
                         int[] appWidgetIds) {
        for (int i=0; i<appWidgetIds.length; i++) {
            Intent svcIntent=new Intent(ctxt, WidgetService.class);

            svcIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetIds[i]);
            svcIntent.setData(Uri.parse(svcIntent.toUri(Intent.URI_INTENT_SCHEME)));

            RemoteViews widget=new RemoteViews(ctxt.getPackageName(),
                                               R.layout.app_widget);

            widget.setRemoteAdapter(appWidgetIds[i], R.id.widget_scores_list,
                                    svcIntent);

            Intent clickIntent=new Intent(ctxt, MainActivity.class);
            PendingIntent clickPI=PendingIntent
                    .getActivity(ctxt, 0,
                                 clickIntent,
                                 PendingIntent.FLAG_UPDATE_CURRENT);

            widget.setPendingIntentTemplate(R.id.widget_scores_list, clickPI);

            appWidgetManager.updateAppWidget(appWidgetIds[i], widget);
        }

        super.onUpdate(ctxt, appWidgetManager, appWidgetIds);
    }
}
//{
//    private Timer timer;
////    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
////                                int appWidgetId)
////    {
////
////        CharSequence widgetText = context.getString(R.string.appwidget_text);
////        // Construct the RemoteViews object
////        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.app_widget);
////        views.setTextViewText(R.id.appwidget_text, widgetText);
////
////        // Instruct the widget manager to update the widget
////        appWidgetManager.updateAppWidget(appWidgetId, views);
////    }
//
//    @Override
//    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds)
//    {
//        // There may be multiple widgets active, so update all of them
////        for (int appWidgetId : appWidgetIds)
////        {
////            updateAppWidget(context, appWidgetManager, appWidgetId);
//            timer = new Timer();
//            timer.scheduleAtFixedRate(new MyTime(context, appWidgetManager), 1, 30000);
////        }
//    }
//
//
//    private class MyTime extends TimerTask
//    {
//        public scoresAdapter mAdapter;
//        RemoteViews remoteViews;
//        AppWidgetManager appWidgetManager;
//        ComponentName thisWidget;
//        DateFormat format = SimpleDateFormat.getTimeInstance(SimpleDateFormat.MEDIUM, Locale.getDefault());
//
//        public MyTime(Context context, AppWidgetManager appWidgetManager)
//        {
//            this.appWidgetManager = appWidgetManager;
//            remoteViews = new RemoteViews(context.getPackageName(), R.layout.app_widget);
//            thisWidget = new ComponentName(context, AppWidget.class);
//        }
//
//        @Override
//        public void run()
//        {
////            remoteViews.setTextViewText(R.id.appwidget_text, "TIME = " + format.format(new Date()));
//            appWidgetManager.updateAppWidget(thisWidget, remoteViews);
//        }
//
//    }
//
//    @Override
//    public void onEnabled(Context context)
//    {
//        // Enter relevant functionality for when the first widget is created
//    }
//
//    @Override
//    public void onDisabled(Context context)
//    {
//        // Enter relevant functionality for when the last widget is disabled
//    }
//}

