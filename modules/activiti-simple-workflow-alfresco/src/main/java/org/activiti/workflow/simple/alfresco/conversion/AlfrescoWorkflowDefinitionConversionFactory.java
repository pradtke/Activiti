/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.activiti.workflow.simple.alfresco.conversion;

import org.activiti.workflow.simple.alfresco.export.AlfrescoArtifactExporter;
import org.activiti.workflow.simple.converter.WorkflowDefinitionConversionFactory;
import org.activiti.workflow.simple.definition.HumanStepDefinition;

/**
 * {@link WorkflowDefinitionConversionFactory} which has additional listeners which
 * creates specific artifacts to use the workflowdefinition in Alfresco.
 * 
 * @author Frederik Heremans
 *
 */
public class AlfrescoWorkflowDefinitionConversionFactory extends WorkflowDefinitionConversionFactory {

  private static final long serialVersionUID = 1L;
  
  protected AlfrescoArtifactExporter artifactExporter;

	public AlfrescoWorkflowDefinitionConversionFactory() {
		super();
		
		artifactExporter = new AlfrescoArtifactExporter();

		// Add additional listeners for Alfresco-specific listeners
		defaultWorkflowDefinitionConversionListeners.add(new InitializeAlfrescoModelsConversionListener());
		
		// Custom step converters
		defaultStepConverters.put(HumanStepDefinition.class, new AlfrescoHumanStepDefinitionConverter());
  }
	
	public AlfrescoArtifactExporter getArtifactExporter() {
	  return artifactExporter;
  }
	
}
