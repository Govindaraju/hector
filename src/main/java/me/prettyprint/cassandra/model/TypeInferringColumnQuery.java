package me.prettyprint.cassandra.model;

import me.prettyprint.cassandra.serializers.StringSerializer;
import me.prettyprint.cassandra.serializers.TypeInferringSerializer;

/**
 * The same as ColumnQuery, but dynamically inferring the serializers
 * needed to transform the key and column name to their binary form.
 *
 * @author Bozhidar Bozhanov
 *
 * @param <K> key type
 * @param <N> column name type
 * @param <V> value type
 */
public class TypeInferringColumnQuery<K, N, V> extends ColumnQuery<K, N, V> {

  public TypeInferringColumnQuery(KeyspaceOperator keyspaceOperator,
      Serializer<V> valueSerializer) {
    super(keyspaceOperator, TypeInferringSerializer.<K>get(),
        TypeInferringSerializer.<N>get(), valueSerializer);
  }

  @SuppressWarnings("unchecked")
  public TypeInferringColumnQuery(KeyspaceOperator keyspaceOperator) {
    super(keyspaceOperator, TypeInferringSerializer.<K> get(),
        TypeInferringSerializer.<N>get(), (Serializer<V>) StringSerializer.get());
  }

  @Override
  public ColumnQuery<K, N, V> setKey(K key) {
    return super.setKey(key);
  }

  @Override
  public ColumnQuery<K, N, V> setName(N name) {
    return super.setName(name);
  }
}
