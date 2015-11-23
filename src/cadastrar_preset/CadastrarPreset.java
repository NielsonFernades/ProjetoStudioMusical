package cadastrar_preset;

public class CadastrarPreset {
	public class Stack implements StackInterface {

		private int index = -1;
		private Object[] array;

		public Stack(int size) {
			array = new Object[size];
		}

		@Override
		public Object pop() {
			if (!empty()) {
				Object obj = array[index];
				array[index] = null;
				--index;
				return obj;
			}
			throw new IllegalArgumentException("A pilha está vazia!");
		}

		@Override
		public void push(Object obj) {
			if (index < size() - 1) {
				array[++index] = obj;
			} else {
				throw new IllegalArgumentException("A pilha está cheia!");
			}
		}

		@Override
		public Object peek() {
			if (!empty()) {
				return array[index];
			}
			throw new IllegalArgumentException("A pilha está vazia!");
		}

		@Override
		public boolean empty() {
			if (index < 0) {
				return true;
			}
			return false;
		}

		@Override
		public int size() {
			return array.length;
		}
	}

}
