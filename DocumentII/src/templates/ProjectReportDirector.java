package templates;

public class ProjectReportDirector {
	private ProjectReportBuilder builder;
	
	public ProjectReportDirector(ProjectReportBuilder builder) {
		this.builder = builder;
	}

	public void direct() {
		builder.withIntroduction("This is a project report")
			.withResultTitle("Test Results")
			.withResult("The result was good!")
			.addReference("W. Sinnema, Digital, Analog, and Data Communication. Reston, NJ: Reston Pub. Co., 2014.")
			.addReference("K. Capova et al., Electromagnetic Nondestructive Evaluation (XVII), Amsterdam: IOS Press, 2014.")
			.build();
	}
	
}
