package com.test.jbehave.story;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import com.test.jbehave.steps.UserAccountListSteps;

public class UserAccountListStory extends JUnitStory{
	@Override
	public Configuration configuration() {
		return new MostUsefulConfiguration();
	}
	
	@Override
	public InjectableStepsFactory stepsFactory() {
		return new InstanceStepsFactory(configuration(),new UserAccountListSteps());
	}
 
	/*@Override
	protected List<String> storyPaths() {
		return Arrays.asList("com/test/jbehave/story/user_account_list_story.story");
	}*/
}
