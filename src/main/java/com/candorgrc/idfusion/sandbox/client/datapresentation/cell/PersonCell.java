package com.candorgrc.idfusion.sandbox.client.datapresentation.cell;

import com.candorgrc.idfusion.sandbox.client.model.PersonJSO;
import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.ValueUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.BrowserEvents;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.client.SafeHtmlTemplates.Template;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;

public class PersonCell extends AbstractCell<PersonJSO> {

	public static enum Action {
		CREATE, UPDATE, COPY, DELETE
	}

	/*
	 * Safe XHTML5 Template instance.
	 */
	private Template template;

	/*
	 * Constructor method
	 */
	public PersonCell() {
		/*
		 * register for consuming click events
		 */
		super(BrowserEvents.CLICK);

		// instantiate Safe HTML Template
		if (template == null) {
			template = GWT.create(Template.class);
		}
	}

	/*
	 * HTML render method.
	 *
	 * (non-Javadoc)
	 *
	 * @see
	 * com.google.gwt.cell.client.AbstractCell#render(com.google.gwt.cell.client
	 * .Cell.Context, java.lang.Object,
	 * com.google.gwt.safehtml.shared.SafeHtmlBuilder)
	 */
	@Override
	public void render(Context context, PersonJSO value, SafeHtmlBuilder sb) {
		if (value != null) {

			// build
			//@formatter:off
			sb.append(template.build(value.getTitle(), 			// 0
								     value.getFirstName(), 		// 1
								     value.getLastName(),  		// 2
								     value.getSuffix(), 		// 3
								     value.getGender(), 		// 4
								     value.getRace(), 			// 5
								     value.getLanguage(), 		// 6
								     value.getUniversity(),		// 7
								     value.getBuzzword(),  		// 8
								     value.getEmail(),  		// 9
								     value.getJobTitle(), 		// 10
								     value.getLinkedinSkill(), 	// 11
								     value.getAvatar(), 		// 12
								     value.getCompany(), 		// 13
								     value.getDepartment(), 	// 14
								     value.getEin(), 			// 15
								     Action.UPDATE.name(), 		// 16
								     Action.COPY.name(), 		// 17
								     Action.DELETE.name())); 	// 18
			//@formatter:on

			// other asynchronous workers may be added here
		}
	}

	/*
	 * Handle Browser Event(s).
	 *
	 * (non-Javadoc)
	 *
	 * @see
	 * com.google.gwt.cell.client.AbstractCell#onBrowserEvent(com.google.gwt.
	 * cell.client.Cell.Context, com.google.gwt.dom.client.Element,
	 * java.lang.Object, com.google.gwt.dom.client.NativeEvent,
	 * com.google.gwt.cell.client.ValueUpdater)
	 */
	@Override
	public void onBrowserEvent(Context context, Element parent, PersonJSO value, NativeEvent event, ValueUpdater<PersonJSO> valueUpdater) {
		super.onBrowserEvent(context, parent, value, event, valueUpdater);
		final Element element = event.getEventTarget().cast();
		final String action = element.getAttribute("action");

		if (!action.isEmpty()) {
			value.setAction(action);
			valueUpdater.update(value);
		}
	}

	/**
	 * Cell XHTML Template.
	 *
	 * @designer: feel free to modify it in order to meet your expectations
	 *
	 */
	public interface Template extends SafeHtmlTemplates {
		//@formatter:off
		@Template("<div class='idf-person-view-cell'>"
				 	+ "<header>"
				 		+ "<figure>"
				 			+ "<img class='avatar' src=\"{12}\"></img>"
				 			+ "<figcaption class='caption'>"
				 				+ "<span class='title' title='Title'>{0}</span>"
				 				+ "<span class='first-name' title='First Name'>{1}</span>"
				 				+ "<span class='last-name' title='Last Name'>{2}</span>"
				 				+ "<span class='suffix' title='Suffix'>{3}</span>"
				 			+ "</figcaption>"
				 		+ "</figure>"
					+ "</header>"
					+ "<section>"
						+ "<div class='idf-person-view-data personal-info'>"
							+ "<div class='idf-person-view-data-group-name'>Personal Info</div>"
							+ "<div><span class='idf-person-view-data-title'>Gender:</span><span><i class='idf-person-view-data-gender-icon {4}' title='{4}'></i></span></div>"
							+ "<div class='race' title='Race'><span class='idf-person-view-data-title'>Race:</span><span>{5}</span></div>"
							+ "<div class='language' title='Language'><span class='idf-person-view-data-title'>Language:</span><span>{6}</span></div>"
						+ "</div>"

						+ "<div class='idf-person-view-data education'>"
							+ "<div class='idf-person-view-data-group-name'>Education</div>"
							+ "<div class='university' title='University'><span class='idf-person-view-data-title'>University:</span><span>{7}</span></div>"
						+ "</div>"

						+ "<div class='idf-person-view-data work'>"
							+ "<div class='idf-person-view-data-group-name'>Work</div>"
							+ "<div class='job-title' title='Job Title'><span class='idf-person-view-data-title'>Job Title:</span><span>{10}</span></div>"
							+ "<div class='company' title='Company'><span class='idf-person-view-data-title'>Company:</span><span>{13}</span></div>"
							+ "<div class='department' title='Department'><span class='idf-person-view-data-title'>Department:</span><span>{14}</span></div>"
							+ "<div class='ein' title='Employer Identification Number'><span class='idf-person-view-data-title'>Eployer ID:</span><span>{15}</span></div>"
							+ "<div class='email' title='E-Mail'><span class='idf-person-view-data-title'>E-Mail:</span><span>{9}</span></div>"
						+ "</div>"

						+ "<aside class='idf-person-view-data'>"
							+ "<div class='idf-person-view-data-group-name'>Other info</div>"
							+ "<div class='linkedin-skill' title='LinkedIn Skill'><span class='idf-person-view-data-title'>LinkedIn:</span><span>{11}</span></div>"
							+ "<div class='buzzword' title='Buzzword'><span class='idf-person-view-data-title'>Buzzword:</span><span>{8}</span></div>"
						+ "</aside>"
					+ "</section>"
					+ "<footer>"
						+ "<nav class='controls'>"
							+ "<button class='edit idf-secondary' action='{16}' title='Edit'><i class='edit' action='{16}'></i> Edit</button>"
							+ "<button class='copy idf-secondary' action='{17}' title='Copy'><i class='copy' action='{17}'></i> Copy</button>"
							+ "<button class='delete idf-secondary' action='{18}' title='Delete'><i class='delete' action='{18}'></i> Delete</button>"
						+ "</nav>"
					+ "</footer>"
				+ "</div>")
		//@formatter:on
		SafeHtml build(String title, String firstName, String lastName, String suffix, String gender, String race, String language, String university, String buzzword,
				String email, String jobTitle, String linkedinSkill, String avatar, String company, String department, String ein, String editAction, String copyAction,
				String deleteAction);
	}

}
