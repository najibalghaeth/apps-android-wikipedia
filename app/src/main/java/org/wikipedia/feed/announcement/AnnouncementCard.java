package org.wikipedia.feed.announcement;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.wikipedia.feed.model.Card;
import org.wikipedia.feed.model.CardType;

public class AnnouncementCard extends Card {
    @NonNull private final Announcement announcement;

    public AnnouncementCard(@NonNull Announcement announcement) {
        this.announcement = announcement;
    }

    @Override
    @NonNull
    public String title() {
        return announcement.type();
    }

    @Nullable
    @Override
    public String extract() {
        return announcement.text();
    }

    public boolean hasAction() {
        return announcement.hasAction();
    }

    @NonNull
    public String actionTitle() {
        return announcement.actionTitle();
    }

    @NonNull
    public Uri actionUri() {
        return Uri.parse(announcement.actionUrl());
    }

    @NonNull
    @Override
    public CardType type() {
        return CardType.ANNOUNCEMENT;
    }

    @Override
    protected int dismissHashCode() {
        return announcement.id().hashCode();
    }
}
