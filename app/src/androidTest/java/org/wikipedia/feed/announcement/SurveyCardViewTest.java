package org.wikipedia.feed.announcement;

import android.support.annotation.NonNull;

import org.junit.experimental.theories.Theory;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.wikipedia.feed.model.CardType;
import org.wikipedia.test.view.FontScale;
import org.wikipedia.test.view.LayoutDirection;
import org.wikipedia.test.view.ViewTest;
import org.wikipedia.theme.Theme;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SurveyCardViewTest extends ViewTest {
    private static final String SURVEY_TEXT = "Answer three questions and help us improve Wikipedia.";
    private static final String SURVEY_ACTION = "Take survey";
    private SurveyCardView subject;

    @Theory public void testWidth(@TestedOn(ints = {WIDTH_DP_L, WIDTH_DP_M}) int widthDp,
                                  @NonNull FontScale fontScale) {
        setUp(widthDp, LayoutDirection.LOCALE, fontScale, Theme.LIGHT);
        snap(subject);
    }

    @Theory public void testLayoutDirection(@NonNull LayoutDirection direction) {
        setUp(WIDTH_DP_M, direction, FontScale.DEFAULT, Theme.LIGHT);
        snap(subject);
    }

    @Theory public void testTheme(@NonNull Theme theme) {
        setUp(WIDTH_DP_M, LayoutDirection.LOCALE, FontScale.DEFAULT, theme);
        snap(subject);
    }

    @Theory public void testFocus(@NonNull Theme theme) {
        setUp(WIDTH_DP_M, LayoutDirection.LOCALE, FontScale.DEFAULT, theme);
        requestFocus(subject);
        snap(subject);
    }

    @Override
    protected void setUp(int widthDp, @NonNull LayoutDirection layoutDirection,
                       @NonNull FontScale fontScale, @NonNull Theme theme) {
        super.setUp(widthDp, layoutDirection, fontScale, theme);
        subject = new SurveyCardView(ctx());
        subject.setCard(mockSurveyCard(SURVEY_TEXT, SURVEY_ACTION));
    }

    @NonNull private SurveyCard mockSurveyCard(String text, String action) {
        SurveyCard card = mock(SurveyCard.class);
        when(card.type()).thenReturn(CardType.SURVEY);
        when(card.title()).thenReturn("survey");
        when(card.actionTitle()).thenReturn(action);
        when(card.hasAction()).thenReturn(true);
        when(card.extract()).thenReturn(text);
        return card;
    }
}