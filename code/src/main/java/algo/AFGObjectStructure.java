package algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AFGObjectStructure {

	// class which is going to be initialized inside Fact
	// an instance of this class will be sent to the execution engine (as part of
	// Fact)
	static class ExcutionResultMap {
		// maps a validatable to all outcomes produced by applicable rules
		private Map<Validatable, ValidatableEvaluationResult> outcome;
	}

	// anything validatable by the engine
	static interface Validatable {
	}

	// a specific implementation of validatable 
	static class Party implements Validatable {

		String id;

		public Party(String partyId) {
			id = partyId;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

	}

	static class EvaluationResult {
		String msg;

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

	}

	static class ValidatableEvaluationResult {

		private List<EvaluationResult> results;

		public List<EvaluationResult> getResults() {
			return results;
		}

		public void setResults(List<EvaluationResult> results) {
			this.results = results;
		}

	}

	static class Fact {

	}

	public static void main(String[] args) {
		
		// constructing the fact from input
		// passing the fact to engine
		ExcutionResultMap e = new ExcutionResultMap();

		e.outcome = new HashMap<>();

		// based on input you are constructing the parties
		Party party1 = new Party("party1");
		Party party2 = new Party("party2");
		Party party3 = new Party("party3");

		e.outcome.put(party1, new ValidatableEvaluationResult());
		e.outcome.put(party2, new ValidatableEvaluationResult());
		e.outcome.put(party3, new ValidatableEvaluationResult());
		
		// fact.put("evaluationResultMap",e);
		
		// invokingEngine(fact);
		
		/*** for a rule ***/

		// rule-1 checks applicability : condition
		// rule-1 applies it's domain logic : action
		// for loop over parties
		// for a given party - party1
		   String str = "rule - 1 failed";
		   // get 'ExcutionResultMap' object from the Fact
		   ValidatableEvaluationResult outcomesForParty = e.outcome.get(party1.getId());
		
		   EvaluationResult msg = new EvaluationResult();
		   msg.setMsg(str);
		   outcomesForParty.getResults().add(msg);
		   
		   
		// rule-2 checks applicability : condition
		// rule-2 applies it's domain logic : action
			// for loop over parties
			// for a given party - party1
//			   String str = "rule - 1 failed";
//			   // get 'ExcutionResultMap' object from the Fact
//			   ValidatableEvaluationResult outcomesForParty = e.outcome.get(party1.getId());
//			
//			   EvaluationResult msg = new EvaluationResult();
//			   msg.setMsg(str);
//			   outcomesForParty.getResults().add(msg);	   
		   
		// aggregate(fact.getE())... ... BFF   

	}

}
