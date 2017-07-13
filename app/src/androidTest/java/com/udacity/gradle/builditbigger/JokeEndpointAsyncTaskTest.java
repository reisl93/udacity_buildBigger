package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.fail;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
public class JokeEndpointAsyncTaskTest {

    @Test
    public void testJokeAsyncTask_stringNotEmpty (){
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final List<String> responseContainer = new LinkedList<>();

        new JokeEndpointAsyncTask() {
            @Override
            protected void onPostExecute(String s) {
                responseContainer.add(s);
                countDownLatch.countDown();
            }
        }.execute();
        try {
            countDownLatch.await(4, TimeUnit.SECONDS);
            if (responseContainer.isEmpty()){
                fail();
            }
        } catch (InterruptedException e) {
            fail();
            e.printStackTrace();
        }
        assertThat("there is a response", responseContainer.get(0).length() > 0, equalTo(true));
    }

}
