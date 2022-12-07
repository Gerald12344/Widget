package com.awesomeproject;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.app.PendingIntent;
import android.widget.RemoteViews;
import android.widget.Toast;

/**
 * Implementation of App Widget functionality.
 */
public class Panik extends AppWidgetProvider {



    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        Toast.makeText( context,"Setup!", Toast.LENGTH_SHORT).show();
        // There may be multiple widgets active, so update all of them.
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    private void updateAppWidget(Context context, AppWidgetManager appWidgetManager, int appWidgetId) {


        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.panik);


        // Setup update button to send an update request as a pending intent.
        Intent intentUpdate = new Intent(context, MyActivity.class);

        // The intent action must be an app widget update.
        intentUpdate.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);

        // Include the widget ID to be updated as an intent extra.
        int[] idArray = new int[]{appWidgetId};
        intentUpdate.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, idArray);

        // Wrap it all in a pending intent to send a broadcast.
        // Use the app widget ID as the request code (third argument) so that
        // each intent is unique.
        PendingIntent pendingUpdate = PendingIntent.getBroadcast(context, appWidgetId, intentUpdate, PendingIntent.FLAG_UPDATE_CURRENT);

        // Assign the pending intent to the button onClick handler
        views.setOnClickPendingIntent(R.id.PANIKBUTTOn, pendingUpdate);

        // Instruct the widget manager to update the widget.
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }


}