/*
 * #%L
 * de-metas-common-rest_api
 * %%
 * Copyright (C) 2021 metas GmbH
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */

package de.metas.common.rest_api.v2;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import javax.annotation.Nullable;
import java.math.BigDecimal;

@Value
public class JsonQuantity
{
	@Schema(required = true)
	BigDecimal qty;

	@Schema(required = true, //
			description = "Unit of measurement; this translates to `C_UOM.X12DE355`.")
	String uomCode;

	@Schema(description = "Unit of measurement symbol; this translates to `C_UOM.UOMSymbol`.")
	String uomSymbol;

	@JsonCreator
	@Builder
	private JsonQuantity(
			@JsonProperty("qty") @NonNull final BigDecimal qty,
			@JsonProperty("uomCode") @NonNull final String uomCode,
			@JsonProperty("uomSymbol") @Nullable final String uomSymbol)
	{
		this.qty = qty;
		this.uomCode = uomCode;
		this.uomSymbol = uomSymbol;
	}
}
