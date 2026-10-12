package com.example.miniapp

import android.appwidget.AppWidgetManager
import android.content.SharedPreferences
import es.antonborri.home_widget.HomeWidgetProvider
import android.content.Context
import android.widget.RemoteViews

/**
 * Implementation of App Widget functionality.
 */
class Appwidgettest : HomeWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray,
        widgetData: SharedPreferences   /*<-- initial where you store the data */
    ) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId, widgetData) /*<-- add the new commands */
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int,
    widgetData: SharedPreferences
) {
    // here we mention which is actucal show the UI data (mention the code...)
    val widgetText = widgetData.getString("widget_text", "Hello World")
    val views = RemoteViews(context.packageName, R.layout.appwidgettest)
    views.setTextViewText(R.id.appwidget_text, widgetText)

    appWidgetManager.updateAppWidget(appWidgetId, views)
}